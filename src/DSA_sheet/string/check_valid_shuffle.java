package DSA_sheet.string;

public class check_valid_shuffle {
    public static void main(String[] args){
        char[] str1 ={'x','y'};
        char[] str2 = {'1','2'};
        char[] res={'1','y','y','2'};
        System.out.println(check(str1,str2,res));
    }

    static boolean check(char[] str1, char[] str2, char[] res){
        int l1=str1.length ;
        int l2 = str2.length ;
        int l3 = res.length ;
        if((l1+l2)!= l3) return false;
        else{
            int i=0,j=0;
            int k=0;
            while(k!=l3){
                if(i<l1 && str1[i]==res[k])i++;
                else if(j<l2 && str2[j] == res[k])j++;
                else{
                    return false;
                }
                k++;
            }
            if(i<l1 || i<l2) return false;
        }
        return true;
    }
}
