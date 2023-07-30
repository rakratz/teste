<?php

use app\User;;

use PHPUnit\Framework\TestCase;

class UserTest extends TestCase
{
    public function testGetName()
    {
        $user = new User('João', 30);
        $this->assertEquals('João', $user->getName());
    }

    public function testGetAge()
    {
        $user = new User('Maria', 25);
        $this->assertEquals(25, $user->getAge());
    }

    public function testGetFullName()
    {
        $user = new User('Carlos', 40);
        $this->assertEquals('Carlos (40 anos)', $user->getFullName());
    }
}
