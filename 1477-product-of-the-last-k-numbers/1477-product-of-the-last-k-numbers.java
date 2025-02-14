import java.util.*;

class ProductOfNumbers {
    List<Integer> prefixProducts;

    public ProductOfNumbers() {
        prefixProducts = new ArrayList<>();
        prefixProducts.add(1); // Initial prefix product
    }
    
    public void add(int num) {
        if (num == 0) {
            prefixProducts.clear();
            prefixProducts.add(1); // Reset on zero
        } else {
            int lastProduct = prefixProducts.get(prefixProducts.size() - 1);
            prefixProducts.add(lastProduct * num);
        }
    }
    
    public int getProduct(int k) {
        int size = prefixProducts.size();
        if (k >= size) {
            return 0; // There were zeros within last k numbers
        }
        return prefixProducts.get(size - 1) / prefixProducts.get(size - 1 - k);
    }
}
