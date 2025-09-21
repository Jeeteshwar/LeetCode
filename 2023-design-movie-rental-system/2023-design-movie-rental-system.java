class MovieRentingSystem {
    private static class Record {
        final int shopId;
        final int movieId;
        final int rentalPrice;
        Record(int shopId, int movieId, int rentalPrice) {
            this.shopId = shopId;
            this.movieId = movieId;
            this.rentalPrice = rentalPrice;
        }
    }

    // Comparator: rentalPrice ↑, shopId ↑, movieId ↑
    private static final Comparator<Record> RECORD_COMPARATOR =
        (a, b) -> {
            int cmp = Integer.compare(a.rentalPrice, b.rentalPrice);
            if (cmp != 0) return cmp;
            cmp = Integer.compare(a.shopId, b.shopId);
            if (cmp != 0) return cmp;
            return Integer.compare(a.movieId, b.movieId);
        };

    // Available movies grouped by movieId
    private final Map<Integer, TreeSet<Record>> availableMovies = new HashMap<>();
    // All rented movies
    private final TreeSet<Record> rentedMovies = new TreeSet<>(RECORD_COMPARATOR);
    // Quick lookup (shopId, movieId) → Record
    private final Map<Long, Record> recordLookup = new HashMap<>();

    private static long buildKey(int shopId, int movieId) {
        return (((long) shopId) << 32) ^ (movieId & 0xffffffffL);
    }

    public MovieRentingSystem(int n, int[][] movieEntries) {
        for (int[] entry : movieEntries) {
            int shopId = entry[0], movieId = entry[1], rentalPrice = entry[2];
            Record record = new Record(shopId, movieId, rentalPrice);
            recordLookup.put(buildKey(shopId, movieId), record);
            availableMovies
                .computeIfAbsent(movieId, k -> new TreeSet<>(RECORD_COMPARATOR))
                .add(record);
        }
    }

    // Return up to 5 shops with this movie
    public List<Integer> search(int movieId) {
        List<Integer> result = new ArrayList<>(5);
        TreeSet<Record> records = availableMovies.get(movieId);
        if (records == null || records.isEmpty()) return result;
        Iterator<Record> iterator = records.iterator();
        for (int i = 0; i < 5 && iterator.hasNext(); i++) {
            result.add(iterator.next().shopId);
        }
        return result;
    }

    // Rent a movie → move from available to rented
    public void rent(int shopId, int movieId) {
        long key = buildKey(shopId, movieId);
        Record record = recordLookup.get(key);
        if (record == null) return; 
        TreeSet<Record> records = availableMovies.get(movieId);
        if (records != null) records.remove(record);
        rentedMovies.add(record);
    }

    // Drop a rented movie → move from rented to available
    public void drop(int shopId, int movieId) {
        long key = buildKey(shopId, movieId);
        Record record = recordLookup.get(key);
        if (record == null) return;
        rentedMovies.remove(record);
        availableMovies
            .computeIfAbsent(movieId, x -> new TreeSet<>(RECORD_COMPARATOR))
            .add(record);
    }

    // Return up to 5 rented movies [shopId, movieId]
    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>(5);
        Iterator<Record> iterator = rentedMovies.iterator();
        for (int i = 0; i < 5 && iterator.hasNext(); i++) {
            Record rec = iterator.next();
            result.add(Arrays.asList(rec.shopId, rec.movieId));
        }
        return result;
    }
}
