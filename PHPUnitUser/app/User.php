<?php

namespace app;

class User
{
    private $name;
    private $age;

    public function __construct(string $name, int $age)
    {
        $this->name = $name;
        $this->age = $age;
    }
    public function getName(): string
    {
        return $this->name;
    }
    public function getAge(): int
    {
        return $this->age;
    }
    public function getFullName(): string
    {
        return $this->name . ' (' . $this->age . ' anos)';
    }
}
