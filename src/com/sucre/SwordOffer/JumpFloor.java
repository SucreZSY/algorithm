package com.sucre.SwordOffer;

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
        if (target == 1 || target == 2) return target;
        return JumpFloor(target -1) + JumpFloor(target - 2);
    }
    //变态跳
    public int JumpFloorII(int target) {
        if (target == 1 || target == 2) return target;
        return JumpFloorII(target - 1) << 1;
    }
}
