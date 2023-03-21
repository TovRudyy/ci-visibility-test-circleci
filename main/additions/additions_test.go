package main

import (
	"testing"
)

func Test_AddNumbers(t *testing.T) {
	ans := addNumbers(2, 5)

	if ans != 7 {
		t.Fatal("Expected 7 but instead got ", ans)
	}
}
