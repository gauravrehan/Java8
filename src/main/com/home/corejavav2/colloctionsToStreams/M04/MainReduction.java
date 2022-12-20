package com.home.corejavav2.colloctionsToStreams.M04;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 *
 * @author Gaurav Rehan
 *
 * This class is a demonstration of hand writing the reduce operation.
 * We need to be extra careful with reduce because
 * a) if there is no identity element (for example 0 is not an identity element if array elements have - numbers)
 * b) the reduction step is non associative (result changes if ordering changes) then we cannot use paralleliztation becuase
 * it would lead to different results when ran at different times.
 */
public class MainReduction {

    public static int reduce(
            List<Integer> values, 
            int valueIfEmpty, 
            BinaryOperator<Integer> reduction) {
        
        int result = valueIfEmpty;
        for (int value : values) {
            result = reduction.apply(result, value);
        }
        return result;
    }
    
    public static void main(String[] args) {
        
        List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4, -1, -2, -3, -4);
        
        List<Integer> ints1 = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> ints2 = Arrays.asList(-1, -2, -3, -4);
        
        BinaryOperator<Integer> op = (i1, i2) -> Integer.max(i1, i2) ;
        
        int reduction1 = reduce(ints1, 0, op);
        int reduction2 = reduce(ints2, 0, op);
        int reduction = reduce(Arrays.asList(reduction1, reduction2), 0, op);
        // int reduction = reduce(ints, 0, op);
        
        System.out.println("Reduction : " + reduction2);
    }
}
