class ProductOfNumbers {
    List<Long> product;
    int prevZero = -1;

    public ProductOfNumbers() {
        product = new ArrayList<>();
    }
    
    public void add(int num) {
        if (num == 0) {
            product.clear();
        }
        else {
            long prev = product.size() > 0 ? product.get(product.size()-1) : 1;
            product.add(num * prev);
        }
    }
    
    public int getProduct(int k) {
        if (k > product.size()) {
            return 0;
        }
        int start = product.size() - k;
        long deno = start < 1 ? 1 : product.get(start - 1);
        return (int) (product.get(product.size() - 1) / deno);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */