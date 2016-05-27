# IDValidator

```java
//初始化一个实例
IDValidator validator = new IDValidator();

//验证身份证是否有效
validator.isValid("152103198909218022")

//分析详细信息
validator.getInfo(id15)

//生成18位身份证号
validator.makeID(false)

//生成15位身份证号
validator.makeID(true)
```

参考：http://blog.jdk5.com/zh/java-chinese-personal-id-card-validation/

#image - 图片处理工具

```java
String str = ImageUtilsTest.class.getResource("/org.jpg").getPath();
File f = new File(str);		//原图片

ImageUtils.fromFile(f)		//设置原图片
	//.width(200)			//设置生成图片的宽度，高度将以原图片的高度等比例伸缩
	//.height(200)			//设置生成图片的高度，宽度将以原图片的宽度等比例伸缩
	//.scale(1)				//设置生成图片的伸缩比例
	//.size(200, 22)		//设置生成图片的宽度和高度
	.rotate(34)				//设置原图片的旋转角度
	.bgcolor(Color.BLUE)	//设置背景颜色
	.quality(0.6f)			//设置压缩比例
	.toFile(new File("d:\\image\\test.jpg"));	//生成图片的路径
```