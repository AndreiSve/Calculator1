package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите задачу");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
    System.out.println(parse(str));}

        public static String parse (String str) throws Exception{
            int num1,num2;
            String oper,result;
            boolean isCalculate;
            String [] operands = str.split("[+\\-*/]");
            if(operands.length != 2) throw new Exception("Формат математической операции не удовлетворяет заданию -два операнда и один операнд / строка не является математичсекой операцией");
            oper = detectOperation(str);
            if (Converter.isRoman(operands[0])&& Converter.isRoman(operands[1])){
                num1 = Converter.convertToArabian(operands[0]);
                num2 = Converter.convertToArabian(operands[1]);
                isCalculate = true;
            } else if (!Converter.isRoman(operands[0]) && !Converter.isRoman(operands[1])) {
                num1 = Integer.parseInt(operands[0]);
                num2 = Integer.parseInt(operands[1]);
                isCalculate = false;

            } else {throw new Exception("Используются одновременно разные системы исчислений");
            }
            if (num1 >10 || num2 > 10){
                throw new Exception("Допускаются только цифры");
            }
            int arabian = calculate(num1,num2,oper);
            if (isCalculate){
                if (arabian <= 0){
                    throw new Exception("В римской системе нет отрицательных чисел");
                }
                result = Converter.convertToRoman(arabian);
            } else {result = String.valueOf(arabian);}
            return result;
        }

        //Проверяем тип системы исчислений
        public static int calculate(int a, int b ,String oper ) {
        if (oper.equals("+")) return a+b;
        else if (oper.equals("-")) return a-b;
        else if (oper.equals("*")) return a*b;
        else return a/b;
        }

        static String detectOperation (String str){
            if (str.contains("+")) return "+";
            else if (str.contains("-")) {return "-";}
            else if (str.contains("*")) {return "*";}
            else if (str.contains("/")) {return "/";}
            else {return null;}

        }

    }
