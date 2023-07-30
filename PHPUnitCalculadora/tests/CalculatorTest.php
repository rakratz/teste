<?php 
// tests/CalculatorTest.php

namespace tests;

use app\Calculator;
use PHPUnit\Framework\TestCase; 

class CalculatorTest extends TestCase {
    public function testAdd() {
        $calculator = new Calculator();
        $result = $calculator->add(2, 3);
        $this->assertEquals(5, $result);
    }

    public function testDivideByZero()
    {
        $this->expectException(\InvalidArgumentException::class);

        $calculator = new Calculator();
        $calculator->divide(10, 0);
    }

}

?>