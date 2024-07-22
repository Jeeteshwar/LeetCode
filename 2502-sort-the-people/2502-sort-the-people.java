class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        // Create a map to associate each height with a name
        Map<Integer, String> map = new HashMap<>();

        // Populate the map with heights as keys and names as values
        for(int i = 0 ; i < names.length ; i++){
            map.put(heights[i], names[i]);
        }

        // Sort the heights array
        Arrays.sort(heights);

        // Create a result array to store the sorted names
        String[] result = new String[heights.length];

        // Iterate over the sorted heights array in reverse order to get names in descending order of heights
        int index = 0;

            // Iterate over the sorted heights array in reverse order
            // This ensures we get the names in descending order of heights
            for(int i = heights.length - 1 ; i >= 0 ; i--){
                result[index] = map.get(heights[i]); // Get the name associated with the current height from the map
                index++; // Increment the index for the result array
            }

        // Return the sorted names array
        return result;
    }
}
