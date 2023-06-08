public class minimumCost {
    public static void main(String[] args) {
        int [] position = {2,2,2,3,3};
        System.out.println(findCost(position));
    }

    static int findCost(int[] position){
        int even = 0;
        for(int i:position)
            if(i%2==0)
                even++;
        return Math.min(even,position.length-even);
    }
}
