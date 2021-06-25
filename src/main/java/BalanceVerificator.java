import java.util.Stack;

public class BalanceVerificator {

    public int verificator(String text){

        // проверяем на пустую строку
        if(text == ""){
            System.out.println("Line is empty!");
            return 0;
        }

        // создаем 2 стека для отслеживания открывающихся скобок
        Stack<Character> openCharBracket = new Stack<Character>();
        Stack<Integer> openNumberBracket = new Stack<Integer>();

        for (int i = 0; i < text.length(); i++){

            char symbol = text.charAt(i);

            // проверяем на окрывающиеся скобки и на содержание посторонних символов
            if (symbol == '(' || symbol == '[' || symbol == '{'){
                openCharBracket.push(symbol);
                openNumberBracket.push(i+1);
                continue;
            }else if(symbol != ')' && symbol != ']' && symbol != '}'){
                System.out.println("A character '" +  text.charAt(i) + "' doesn’t belong to any known brackets type, returns IllegalArgumentException");
                return 0;
            }


            // проверяем на содержание закрывающейся сктрочки в начале строки
            if (openCharBracket.isEmpty()){
                System.out.println("NOT BALANCED (" + (i+1) + ")");
                return i+1;
            }

            // проверяем на соответствие закрывающихся скобок
            char closedBracket;
            int last;
            switch (symbol) {
                case ')':
                    closedBracket = openCharBracket.pop();
                    last = openNumberBracket.pop();
                    if (closedBracket == '{' || closedBracket == '['){
                        System.out.println("NOT BALANCED (" + last + ")");
                        return last;
                    }
                    break;

                case '}':
                    closedBracket = openCharBracket.pop();
                    last = openNumberBracket.pop();
                    if (closedBracket == '(' || closedBracket == '['){
                        System.out.println("NOT BALANCED (" + last + ")");
                        return last;
                    }
                    break;

                case ']':
                    closedBracket = openCharBracket.pop();
                    last = openNumberBracket.pop();
                    if (closedBracket == '(' || closedBracket == '{'){
                        System.out.println("NOT BALANCED (" + last + ")");
                        return last;
                    }
                    break;
            }
        }


        // проверяем на то, все ли скобки нашли пару
        int result;
        if(!openNumberBracket.isEmpty()){
            result = openNumberBracket.pop();
            System.out.println("NOT BALANCED (" + result + ")");
            return result;
        }


        System.out.println("BALANCED");
        return -1;
    }

}