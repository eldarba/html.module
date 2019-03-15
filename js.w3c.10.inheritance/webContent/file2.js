(function() { // IIFE - Immediately-invoked function expression

	"use strict";

	function Color() {
	}
	Color.prototype.white = "WHITE";
	Color.prototype.black = "BLACK";
	Color.prototype.red = "RED";
	Color.prototype.green = "GREEN";
	Color.prototype.blue = "BLUE";

	function Shape(color) {
		this.color = color;
	}

	function Rectangle(color, length, width) {
		Shape.call(this, color); // invoke super type CTOR function
		this.length = length;
		this.width = width;
	}
	// set the super type
	Rectangle.prototype = Object.create(Shape.prototype);
	// set the constructor property
	Rectangle.prototype.constructor = Rectangle;

	// start running
	console.log("=== start ===");
	var s1 = new Shape(Color.prototype.black);
	var s2 = new Shape(Color.prototype.blue);
	console.log(s1);
	console.log(s2);

	var color = new Color();
	var r1 = new Rectangle(color.green, 5, 6);
	console.log(r1);

	console.log("=== end =====");

})();