package com.bchd.inspection.ui.Control;

public enum SelectCheckItemControlValue {
	/*通过括号赋值,而且必须有带参构造器和一属性跟方法，否则编译出错
     * 赋值必须是都赋值或都不赋值，不能一部分赋值一部分不赋值
     * 如果不赋值则不能写构造器，赋值编译也出错*/
	Pass(0),Fail(1),NA(2);
	
	
	private final int value;
    public int getValue() {
        return value;
    }
    //构造器默认也只能是private, 从而保证构造函数只能在内部使用
    SelectCheckItemControlValue(int value) {
        this.value = value;
    }
}
