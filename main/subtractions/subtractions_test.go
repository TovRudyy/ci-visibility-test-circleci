package subtractions

import "testing"

func Test_SubtractNumbers(t *testing.T) {
	ans := subtractNumbers(10, 7)

	if ans != 3 {
		t.Fatal("Expected 3 but got ", ans)
	}
}
