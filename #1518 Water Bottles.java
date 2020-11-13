//https://leetcode.com/problems/water-bottles/
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int emptyBottles = numBottles;
        int waterBottlesDrunk = numBottles;
        
        while(emptyBottles >= numExchange) {
            emptyBottles -= numExchange;
            waterBottlesDrunk++;
            emptyBottles++;
        }
        return waterBottlesDrunk;
    }
}