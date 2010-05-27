/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.mahout.df.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Helper methods that deals with data lists and arrays of values
 */
public final class DataUtils {
  private DataUtils() { }
  
  /**
   * Computes the sum of the values
   * 
   * @param values
   * @return
   */
  public static int sum(int[] values) {
    int sum = 0;
    for (int value : values) {
      sum += value;
    }
    
    return sum;
  }
  
  /**
   * foreach i : array1[i] += array2[i]
   * 
   * @param array1
   * @param array2
   */
  public static void add(int[] array1, int[] array2) {
    if (array1.length != array2.length) {
      throw new IllegalArgumentException("array1.length != array2.length");
    }
    
    for (int index = 0; index < array1.length; index++) {
      array1[index] += array2[index];
    }
  }
  
  /**
   * foreach i : array1[i] -= array2[i]
   * 
   * @param array1
   * @param array2
   */
  public static void dec(int[] array1, int[] array2) {
    if (array1.length != array2.length) {
      throw new IllegalArgumentException("array1.length != array2.length");
    }
    
    for (int index = 0; index < array1.length; index++) {
      array1[index] -= array2[index];
    }
  }
  
  /**
   * return the index of the maximum of the array, breaking ties randomly
   * 
   * @param rng
   *          used to break ties
   * @param values
   * @return index of the maximum
   */
  public static int maxindex(Random rng, int[] values) {
    int max = 0;
    List<Integer> maxindices = new ArrayList<Integer>();
    
    for (int index = 0; index < values.length; index++) {
      if (values[index] > max) {
        max = values[index];
        maxindices.clear();
        maxindices.add(index);
      } else if (values[index] == max) {
        maxindices.add(index);
      }
    }
    
    int bestind;
    if (maxindices.size() > 1) {
      // break ties randomly
      bestind = maxindices.get(rng.nextInt(maxindices.size()));
    } else {
      bestind = maxindices.get(0);
    }
    
    return bestind;
  }
}
