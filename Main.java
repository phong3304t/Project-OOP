public class Main {

    public static void main(String[] args) {
        test obj = new test();
        System.out.println(obj.h);
        Solution frac1 = new Solution(1, 2);
        Solution frac2 = new Solution(2, 3);

        frac1.add(frac2);
        System.out.println(frac1.getNumerator() + "///" + frac1.getDenominator());
    }
}

