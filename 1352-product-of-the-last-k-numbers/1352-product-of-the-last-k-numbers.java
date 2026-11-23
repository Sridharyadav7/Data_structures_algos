class ProductOfNumbers {
    List<Long> product;
    int prevZero = -1;

    public ProductOfNumbers() {
        product = new ArrayList<>();
    }
    
    public void add(int num) {
        long prev = product.size() == 0 ? 1 : product.get(product.size()-1);
        if (product.size() > 0 && prev == 0) {
            product.add((long) num);
        }
        else {
            product.add(num * prev);
        }

        if (num == 0) {
            prevZero = product.size() - 1;
        }
    }
    
    public int getProduct(int k) {
        int start = product.size() - k;
        if (prevZero >= start) {
            return 0;
        }
        long deno = start < 1 || product.get(start - 1) == 0 ? 1 : product.get(start - 1);
        return (int) (product.get(product.size()-1) / deno);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */