

public class stringbuilder {
    public static void main(String[] args) {
        StringBuilder builder= new StringBuilder();//strings are immutable thus sting bulder it is mutable
        for (int i = 0; i < 26; i++) {
            char ch=(char)('A'+i);
            builder.append(ch);
            builder.append(" ");
        }
        System.out.println(builder);
    }
}
