package DSA_sheet.string;

public class shuffle_string_indicies {
    public static void main(String[] args){
        String s = "codeleet";
        int[] indices = {4,5,6,7,0,2,1,3};
        char[] c = new char[indices.length];
        int i=0;
        while(i< indices.length){
            c[indices[i]] = s.charAt(i);
            i++;
        }
        System.out.println(String.valueOf(c));
    }
}
