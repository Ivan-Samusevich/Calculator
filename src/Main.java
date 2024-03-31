import java.util.Arrays;
import java.util.List;
import java.util.Scanner;





public class Main {
    public static String calc(String Str)
    {
        int ArabKol = 0;
        int RimKol = 0;
        List<String> Arab = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        List<String> Rim = Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII" ,"IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII" ,"XIX", "XX","XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII" ,"XXIX", "XXX","XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII" ,"XXXIX", "XL","XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII" ,"XLIX", "L","LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII" ,"LIX", "LX","LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII" ,"LXIX", "LXX","LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII" ,"LXXIX", "LXXX","LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII" ,"LXXXIX", "XC","XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII" ,"XCIX", "C");
        String[] Znaki = {" + ", " - ", " / ", " * "};
        String[] Regex = {"\\+", "-", "/", "\\*"};
        String number1 = "", number2 = "";
        int ZnakIndex = -1;

        for(int i = 0; i < Znaki.length; i++)
        {
            if(Str.contains(Znaki[i]))
            {
                ZnakIndex = i;
                break;
            }
        }

        if(ZnakIndex == -1)
        {
            return "throw Exception";
        }

        String[] Numbers = Str.split(Regex[ZnakIndex]);

        if(Numbers.length != 2)
        {
            return "throw Exception";
        }

        number1 = Numbers[0].replace(" ", "");
        number2 = Numbers[1].replace(" ", "");

        if(Arab.contains(number1) && Arab.contains(number2))
        {
            ArabKol++;
        }

        if(Rim.contains(number1) && Rim.contains(number2))
        {
            int index1 = Rim.indexOf(number1);
            int index2 = Rim.indexOf(number2);
            if(index2 > 9 || index1 > 9)
            {
                return "throw Exception";
            }
            number1 = Arab.get(index1);
            number2 = Arab.get(index2);
            RimKol++;
        }

        int answer = 0;



        if(ArabKol == 1 || RimKol == 1)
        {
            answer = switch (Znaki[ZnakIndex]) {
                case " + " -> Integer.parseInt(number1) + Integer.parseInt(number2);
                case " - " -> Integer.parseInt(number1) - Integer.parseInt(number2);
                case " * " -> Integer.parseInt(number1) * Integer.parseInt(number2);
                default -> Integer.parseInt(number1) / Integer.parseInt(number2);
            };
        }
        else
        {
            return  "throw Exception";
        }

        if(RimKol == 1)
        {
            if(Znaki[ZnakIndex].equals(" - ") && Integer.parseInt(number1) <= Integer.parseInt(number2))
            {
                return "throw Exception";
            }

            else
            {
                return Rim.get(answer - 1);
            }
        }


        return Integer.toString(answer);
    }
    public static void main(String[] args) {
        Scanner Keyboard = new Scanner(System.in, "cp1251");
        String Str = Keyboard.nextLine();
        String answer = calc(Str);
        System.out.println(answer);
    }
}