package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void minMove(ArrayList<Integer> nums) {

        Collections.sort(nums);

        int index = nums.size() / 2;
        int move = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(index) != nums.get(i)) {
                move += Math.abs(nums.get(index) - nums.get(i));
            }
        }
        System.out.println(move);
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(new File(args[0]))) {

            ArrayList<Integer> nums = new ArrayList<>();

            while (sc.hasNext()) {
                nums.add(sc.nextInt());
            }

            minMove(nums);

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
