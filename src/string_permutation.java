public class string_permutation {
    public static void main (String[] args){
        permutations_recc("kunal","");
    }

    static void permutations_recc(String str, String ans){
        if(str.isEmpty()){
            System.out.println(ans);
            return;
        }
        char ch= str.charAt(0);
        for (int i = 0; i <= ans.length(); i++) {
            String f = ans.substring(0,i);
            String s=ans.substring(i);
            permutations_recc(str.substring(1),f+ch+s);
        }
    }
}
