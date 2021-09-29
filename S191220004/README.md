## Task 1

### **Example的类图**

![image-20210929125750468](C:\Users\10513\AppData\Roaming\Typora\typora-user-images\image-20210929125750468.png)

### 对象时序图

![image-20210929125815173](C:\Users\10513\AppData\Roaming\Typora\typora-user-images\image-20210929125815173.png)

### 理解example的设计理念

1. 对象的设置丰富：根据动画人物，对老爷爷，葫芦娃进行对象的建模，又根据动画场景，对排序过程设置了Line、Sorter、Position等对象，通过各个对象之间的交互，使代码的运行效果更加符合真实场景，如针对排序的动作，需要Geezer调用Sorter，获取信息后再将信息传递给Gourd，最后由Gourd进行swapPosition，符合老爷爷指挥葫芦娃排序的场景。
2. 对象的可扩展性：对于排序，设置了Sorter接口，此后则可采用各种不同的排序算法，在Sorter接口上进行具体实现；对于排序的对象，设置了Linable接口，之后则可根据不同场景实现不同的具体人物，既具有了Linable的共性，又可以添加对象自身的一些独特功能。
3. 对象的一些限定：Geezer采用了单例模式，则只能创建唯一实例，提供一个全局访问点，正如在本场景中只有唯一的老爷爷；Gourd的颜色信息采用了final关键字，保证颜色信息不能被修改，满足了每个Gourd有独特颜色的要求。

### **代码的改进之处**

1. Gourd（Linable）与Position两个类互是对方的私有成员变量，关联性很强，每次交换位置时需要对两个类的信息都进行修改；同时Position又作为Line的内部类和私有成员变量，函数调用过程繁杂，使代码在此处似乎过于复杂化，一开始难以理解，个人认为可以将Position和Line合并为一个类，或将位置信息直接作为Linable内部的变量以避免反复调用。
2. Gourd采用枚举类型在排序的数目较少时可行，但当数量较大时则不合适，如task2和task3中则需将类型改为普通的类以更好的满足需求。
3. 将成员变量的声明置于类的初始位置（构造函数之前）应该会更加符合代码的阅读习惯。

## Task 2

### 类图

![image-20210929125831927](C:\Users\10513\AppData\Roaming\Typora\typora-user-images\image-20210929125831927.png)

### 可视化结果链接

【注：64个妖怪，根据数字排序】

**选择排序：** https://asciinema.org/a/KePiYruUGYqd4IKxubl8h8bzK

**快速排序：**  https://asciinema.org/a/vrG7i5U9JlsNoEtlP0gyGuhB1

## Task 3

### 类图

![image-20210929125902253](C:\Users\10513\AppData\Roaming\Typora\typora-user-images\image-20210929125902253.png)

### 可视化结果链接

【注：144个小妖怪，方阵12 * 12，根据数字排序】

**选择排序：** https://asciinema.org/a/WPuhgT5cRG1tCEk8WYr64IyDg

**快速排序：**https://asciinema.org/a/tLPpIyIl6WnQCqiDC5hllxvpK