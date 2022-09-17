import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

/*
 * Реализуйте сущность “Deque” с помощью массива Integer, массив ограничен в размере size <=5 . 
 * Нужно реализовать методы:
 * - boolean offerFirst(Integer element); //добавляет элемент element в самое начало массива. 
 * Если элемент удачно добавлен, возвращает true, иначе - false
 * - boolean offerLast(Integer element); //добавляет элемент element в конец массива. 
 * Если элемент удачно добавлен, возвращает true, иначе - false
 * - Integer peekFirst(); //возвращает без удаления элемент из начала массива. 
 * Если массив пуст, возвращает значение null
 * - Integer peekLast(); //возвращает без удаления последний элемент массива. 
 * Если массив пуст, возвращает значение null
 * - Integer pollFirst(); //возвращает с удалением элемент из начала массива. 
 * Если массив пуст, возвращает значение null
 * - Integer pollLast(); //возвращает с удалением последний элемент массива. 
 * Если массив пуст, возвращает значение null
 */

public class Task1HM {
    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Enter random array length: ");
        int arrayLength = iScanner.nextInt();
        ArrayList<Integer> workArrayList = filledArrayList(arrayLength);
        logger.info(String.format("Random array: %s", Arrays.toString(workArrayList.toArray())));

        System.out.println("\nChoose action:\n" +
            "1 - offer first element\n" +
            "2 - offer last element\n" + 
            "3 - peek first element\n" + 
            "4 - peek last element\n" + 
            "5 - poll first element\n" + 
            "6 - poll last element\n");
        int action = iScanner.nextInt();
        switch (action) {
            case 1:
                workArrayList = isOfferFirst(workArrayList);
                logger.info(String.format("Transformed array: %s\n", Arrays.toString(workArrayList.toArray())));
                break;
            case 2:
                workArrayList = isOfferLast(workArrayList);
                logger.info(String.format("Transformed array: %s\n", Arrays.toString(workArrayList.toArray())));
                break;
            case 3:
                Integer resThirdAction = peekFirst(workArrayList);
                
                if (resThirdAction != null) {
                    logger.info(String.format("First element: %d", resThirdAction));
                } else {
                    logger.info("null");
                }
                break;
            case 4:
                Integer resFourthAction = peekLast(workArrayList);

                if (resFourthAction != null) {
                    logger.info(String.format("Last element: %d", resFourthAction));
                } else {
                    logger.info("null");
                }
                break;
            case 5:
                Integer resFifthAction = pollFirst(workArrayList);

                logger.info(String.format("Transformed array: %s\n", Arrays.toString(workArrayList.toArray())));
                if (resFifthAction != null) {
                    logger.info(String.format("First polled element: %d", resFifthAction));
                } else {
                    logger.info("null");
                }
                break;
            case 6:
                Integer resSixthAction = pollLast(workArrayList);

                logger.info(String.format("Transformed array: %s\n", Arrays.toString(workArrayList.toArray())));
                if (resSixthAction != null) {
                    logger.info(String.format("Last polled element: %d", resSixthAction));
                } else {
                    logger.info("null");
                }
                break;
            default:
                logger.info(String.format("Incorrect data. Try again with choose from list (1, 2, 3, 4, 5 or 6)"));
                break;
        }
        iScanner.close();
    }
    
    public static ArrayList<Integer> filledArrayList(int arrayLength) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arrayLength; i++) {
            result.add((int) ((Math.random() * 199) - 100));
        }
        return result;
    }

    public static ArrayList<Integer> isOfferFirst(ArrayList<Integer> aIntegers) {
        Logger logger = Logger.getAnonymousLogger();
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Enter number to add: ");
        int userNumber = iScanner.nextInt();
        ArrayList<Integer> resultArray = new ArrayList<Integer>();
        resultArray.add(userNumber);
        resultArray.addAll(aIntegers);
        boolean result;
        result = false;

        if (resultArray.size() == aIntegers.size() + 1) {
            result = true;  
        }

        logger.info(String.format("Is element add to array? %b", result));
        iScanner.close();
        return resultArray;
    }

    public static ArrayList<Integer> isOfferLast(ArrayList<Integer> aIntegers) {
        Logger logger = Logger.getAnonymousLogger();
        int tempNumber = aIntegers.size();
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Enter number to add: ");
        int userNumber = iScanner.nextInt();
        aIntegers.add(userNumber);
        boolean result;
        result = false;

        if (aIntegers.size() == tempNumber + 1) {
            result = true;
        }

        logger.info(String.format("Is element add to array? %b", result));
        iScanner.close();
        return aIntegers;
    }

    public static Integer peekFirst(ArrayList<Integer> aIntegers) {
        if (aIntegers.size() > 0) {
            return aIntegers.get(0);
        } else {
            return null;
        }
    }

    public static Integer peekLast(ArrayList<Integer> aIntegers) {
        if (aIntegers.size() > 0) {
            return aIntegers.get(aIntegers.size() - 1);
        } else {
            return null;
        }
    }

    public static Integer pollFirst(ArrayList<Integer> aIntegers) {       
        if (aIntegers.size() > 0) {
            int tempNumber = aIntegers.get(0);
            aIntegers.remove(0);
            return tempNumber;
        } else {
            return null;
        }
    }

    public static Integer pollLast(ArrayList<Integer> aIntegers) {
        if (aIntegers.size() > 0) {
            int tempNumber = aIntegers.get(aIntegers.size() - 1);
            aIntegers.remove(aIntegers.size() - 1);
            return tempNumber;
        } else {
            return null;
        }
    }
}