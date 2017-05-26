//主体--时钟部分
	var canvas = document.getElementById('clock');
	var ctx = canvas.getContext('2d');
	var width = ctx.canvas.width;
	var height = ctx.canvas.height;
	var r = width / 2;
	var scale = width / 200;
	
//画圆,画60个小圆点,写12个数字	
	function drawCircle(){
		ctx.save();
//		画圆
		ctx.translate(r,r);
		ctx.beginPath();
		ctx.lineWidth = 10 * scale;
		ctx.arc(0,0,r - ctx.lineWidth / 2,0,2 * Math.PI,false);
		ctx.stroke();
		
//		画60个小圆点
		for(var i = 0;i < 60;i ++){
			var rad = 2 * Math.PI / 60 * i;
			var x = Math.cos(rad) * (r - 15 * scale);
			var y = Math.sin(rad) * (r - 15 * scale);
			ctx.beginPath();
			if(i % 5 === 0){
				ctx.fillStyle = 'black';
			}else{
				ctx.fillStyle = 'darkgray';
			}		
			ctx.arc(x,y,2 * scale,0,2 * Math.PI,false);
			ctx.fill();
		}
		
//		写12个数字
		var Arr = [3,4,5,6,7,8,9,10,11,12,1,2];
		Arr.forEach(function(number,i){
			var rad = 2 * Math.PI / 12 * i;
			var x = Math.cos(rad) * (r - 30 * scale);
			var y = Math.sin(rad) * (r - 30 * scale);
			ctx.font = 18 * scale + 'px Arial';
			ctx.textAlign = 'center';
			ctx.textBaseline = 'middle';
			ctx.fillStyle = 'black';
			ctx.fillText(number,x,y);	
		});
	
	}
	
//	drawCircle();
	
//	画时针
	function drawHour(hour,minute){
		ctx.save();
		ctx.beginPath();
		ctx.lineWidth = 5 * scale;
		ctx.lineCap = 'round';
		var rad = 2 * Math.PI / 12 * hour;
		var mrad = 2 * Math.PI / 12 / 60 * minute;
		ctx.rotate(rad + mrad);
		ctx.moveTo(0,10 * scale);
		ctx.lineTo(0, -r / 2);
		ctx.stroke();
		ctx.restore();
	}
	
//	drawHour(4,30);

//	画分针
	function drawMinute(minute){
		ctx.save();
		ctx.beginPath();
		ctx.lineWidth = 3 * scale;
		ctx.lineCap = 'round';
		var rad = 2 * Math.PI / 60 * minute;
		ctx.rotate(rad);
		ctx.moveTo(0,10 * scale);
		ctx.lineTo(0,-r + 26 * scale);
		ctx.stroke();
		ctx.restore();
	}
		
//	drawMinute(30);
	
//	画秒针
	function drawSecond(second){
		ctx.beginPath();
		ctx.fillStyle = '#D02100';
		var rad = 2 * Math.PI / 60 * second;
		ctx.rotate(rad);
		ctx.moveTo(-1,-r + 18 * scale);
		ctx.lineTo(-2, 18* scale);
		ctx.lineTo(2, 18* scale);
		ctx.lineTo(1, -r + 18 * scale);
		ctx.fill();
	}
		
//	drawSecond(15);
	
//	画固定的圆点
	function drawDot(){
		ctx.beginPath();
		ctx.fillStyle = '#fff';
		ctx.arc(0,0,3* scale,0,2 * Math.PI,false);
		ctx.fill();
	}
		
//	drawDot();
	
//	设置时间间隔,使时钟上的时间不断更新,和系统时间保持一致
	function draw(){
		ctx.clearRect(0,0,width,height);
		var now = new Date();
		var hour = now.getHours();
		var minute = now.getMinutes();
		var second = now.getSeconds();
		
		drawCircle();
		drawHour(hour,minute);
		drawMinute(minute);
		drawSecond(second);
		drawDot();
		ctx.restore();	
	}
	
	draw();
	
	setInterval(draw,1000);	