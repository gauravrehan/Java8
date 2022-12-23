package com.home.corejavav2.collectorsOptionalsDataProcessing.M04;

import java.util.Optional;

/**
 *
 * @author Gaurav Rehan
 */
public class NewMath {

    public static Optional<Double> inv(Double d) {
        return d == 0d ? Optional.empty() :
                         Optional.of(1d/d);
    }
    
    public static Optional<Double> sqrt(Double d) {
        return d < 0d ? Optional.empty() :
                        Optional.of(Math.sqrt(d));
    }
}
