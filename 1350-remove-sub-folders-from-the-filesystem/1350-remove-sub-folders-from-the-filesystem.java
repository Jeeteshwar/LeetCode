import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        // Step 1: Sort the folders lexicographically (alphabetical order)
        Arrays.sort(folder);  
        
        // Step 2: Initialize the result list and add the first folder
        int n = folder.length; // Get the total number of folders
        ArrayList<String> res = new ArrayList<>();
        res.add(folder[0]);  // Add the first folder to the result list

        // Step 3: Loop through the rest of the folders (starting from the second one)
        for (int i = 1; i < n; i++) {
            String currFolder = folder[i]; // Current folder to be checked
            String lastFolder = res.get(res.size() - 1); // Last folder added to the result

            // Add a trailing '/' to the last folder for comparison purposes
            lastFolder += "/"; 

            // Step 4: Check if the current folder is a subfolder of the last folder
            if (!currFolder.startsWith(lastFolder)) {
                // Step 5: If it's not a subfolder, add it to the result list
                res.add(currFolder); 
            }
        }

        // Step 6: Return the result list which contains only non-subfolder paths
        return res;
    }
}
