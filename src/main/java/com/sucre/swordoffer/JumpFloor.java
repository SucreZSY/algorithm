package com.sucre.swordoffer;

/**
 * 跳台阶
 */
public class JumpFloor {
    /**
     * 每次跳一格或两格
     * @param target 台阶高度
     * @return 跳法种数
     */
    public int JumpFloor(int target) {
       return (target == 1 || target == 2) ? target : JumpFloor(target - 1) + JumpFloor(target - 2);
    }
    //变态跳
    public int JumpFloorII(int target) {
        return (target == 1) ? target : JumpFloorII(target - 1) << 1;
    }
}
