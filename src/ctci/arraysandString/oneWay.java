package ctci.arraysandString;

public class oneWay {
    public static void main(String[] args){
        String str1="pale";
        String str2 ="ple";
        //replace the code below with a seperate helper function
        if(str1.length() == str2.length()){
            System.out.println(replace_once(str1,str2));
        }else if(Math.abs(str1.length() - str2.length()) == 1){
            if(str1.length() < str2.length()){
                System.out.println(insert_once(str1,str2));
            }else{
                System.out.println(insert_once(str2,str1));
            }
        }
        System.out.println(false);
    }
    static boolean replace_once(String str1, String str2){
        boolean replaced = false;
        for(int i = 0; i<str1.length() ; i++){
            if(str1.charAt(i) != str2.charAt(i)) {
                if(replaced) return false;
                replaced = true;
            }
        }
        return true;
    }

    static boolean insert_once(String min_str, String max_str){
            int max_ptr = 0, min_ptr =0;

            while(min_ptr <min_str.length() && max_ptr <max_str.length()){
                if(min_str.charAt(min_ptr) != max_str.charAt(max_ptr)){
                    if(min_ptr != max_ptr){
                        return false;
                    }
                    max_ptr++;

                }
                else{
                    max_ptr++;
                    min_ptr++;
                }
            }
            return true;
    }

}
