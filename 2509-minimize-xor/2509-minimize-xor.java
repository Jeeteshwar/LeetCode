class Solution {

    public boolean isBitSet(int number, int position) {
        return (number & (1 << position)) != 0;
    }

    public int setBit(int number, int position) {
        return number | (1 << position);
    }

    public int clearBit(int number, int position) {
        return number & ~(1 << position);
    }

    public boolean isBitClear(int number, int position) {
        return (number & (1 << position)) == 0;
    }

    public int minimizeXor(int inputNumber, int referenceNumber) {
        int result = 0;

        int targetSetBitCount = Integer.bitCount(referenceNumber);

        // Retain set bits of inputNumber as much as possible
        for (int position = 31; position >= 0 && targetSetBitCount > 0; position--) {
            if (isBitSet(inputNumber, position)) {
                result |= (1 << position);
                targetSetBitCount--;
            }
        }

        // Set additional bits in result to match targetSetBitCount
        for (int position = 0; position < 32 && targetSetBitCount > 0; position++) {
            if (isBitClear(inputNumber, position)) {
                result |= (1 << position);
                targetSetBitCount--;
            }
        }

        return result;
    }
}
