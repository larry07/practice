```text
padding margin都是边距的含义，关键问题得明白是什么相对什么的边距．padding是控件的内容相对控件的边缘的边距．margin是控件边缘相对父空间的边距．
```

在CSS中margin是指从自身边框到另一个容器边框之间的距离，就是<u>容器外距离</u>。在CSS中padding是指自身边框到自身内部另一个容器边框之间的距离，就是<u>容器内距离</u>。

![css](E:\work\css.jpg)

​	父元素设置了相对定位后，子元素就都会在父元素内绝对定位。如果父元素不设置相对定位的话，里边的子元素会默认相对浏览器定位，当浏览器放大缩小时页面就会乱掉

div#main>div.box*32>div.pic>img[src="images/$.jpg"]



<link type="text/css" rel="stylesheet" href="css/style.css" />

血的教训 

```javascript
*{
	margin: 0;
	padding: 0;
}

#main{
	position: relative;
};         错误就在这里 多了分号

.pin{
	padding: 15px 0 0 15px;
	float:left;
}

.box{
	padding: 10px;
	box-shadow:0 0 5px #ccc;
	border: 1px solid #ccc;
	border-radius: 5px;	
}

.box img{
	width: 165px;
	height:auto;
}
```

