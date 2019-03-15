/**
 * 
 */

"use strict";

function Color() {
}
Color.prototype.c1 = "WHITE";
Color.prototype.c2 = "BLACK";
Color.prototype.c3 = "RED";
Color.prototype.c4 = "GREEN";
Color.prototype.c5 = "BLUE";
Color.prototype.c6 = "PINK";

function Shape(color) {
	this.color = color;
}
Shape.prototype.getArea = function() {
	return -1;
};

function Rectangle(color, a, b) {
	Shape.call(this, color);
	this.a = a;
	this.b = b;
}
Rectangle.prototype = Object.create(Shape.prototype);
Rectangle.prototype.constructor = Rectangle;
Rectangle.prototype.getArea = function() {
	return this.a * this.b;
};

function Circle(color, r) {
	Shape.call(this, color);
	this.r = r;
}
Circle.prototype = Object.create(Shape.prototype);
Circle.prototype.constructor = Circle;
Circle.prototype.getArea = function() {
	return Math.PI * Math.pow(this.r, 2);
};

// IIFE
(function() {
	console.log("=== start ===");

	var c1 = new Circle(Color.prototype.c3, 5);
	console.log(c1);
	console.log(c1.getArea());

	var r1 = new Rectangle(Color.prototype.c1, 5, 7)
	console.log(r1);
	console.log(r1.getArea());
	console.log("=== end =====");
})();