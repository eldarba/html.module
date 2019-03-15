/**
 * 
 */
"use strict";
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

function Circle(color, radius) {
	Shape.call(this, color);
	this.radius = radius;
}
Circle.prototype = Object.create(Shape.prototype);
Circle.prototype.constructor = Circle;
Circle.prototype.getArea = function() {
	return Math.PI * Math.pow(this.radius, 2);
};

function main1() {

	var s, r, c;

	s = new Shape("Red");
	r = new Rectangle("Pink", 5, 4);
	c = new Circle("Blue", 3);

	console.log(s);
	console.log(s.getArea());
	console.log(r);
	console.log(r.getArea());
	console.log(c);
	console.log(c.getArea());
}