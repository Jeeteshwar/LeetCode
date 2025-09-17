import java.util.*;

class FoodRatings {
    
    // Map from food name to its cuisine and rating
    private Map<String, String> foodToCuisine;
    private Map<String, Integer> foodToRating;
    
    // Map from cuisine to sorted set of foods based on rating and name
    private Map<String, TreeSet<String>> cuisineToFoods;
    
    // Custom comparator for TreeSet
    private Comparator<String> foodComparator = (a, b) -> {
        int ratingA = foodToRating.get(a);
        int ratingB = foodToRating.get(b);
        if (ratingA != ratingB) {
            return ratingB - ratingA; // Descending order of rating
        }
        return a.compareTo(b); // Lexicographically smallest if same rating
    };
    
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToFoods = new HashMap<>();
        
        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];
            
            foodToCuisine.put(food, cuisine);
            foodToRating.put(food, rating);
            
            cuisineToFoods.putIfAbsent(cuisine, new TreeSet<>(foodComparator));
            cuisineToFoods.get(cuisine).add(food);
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        TreeSet<String> set = cuisineToFoods.get(cuisine);
        
        // Remove old rating and reinsert with new rating
        set.remove(food);
        foodToRating.put(food, newRating);
        set.add(food);
    }
    
    public String highestRated(String cuisine) {
        return cuisineToFoods.get(cuisine).first();
    }
}
