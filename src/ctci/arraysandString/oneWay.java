//package ctci.arraysandString;
//
//public class oneWay {
//    public static void main(String[] args) {
//        export function areOneAway(leftWord: string, rightWord: string): boolean {
//            let leftIndex = 0;
//            let rightIndex = 0;
//            let mismatchCount = 0;
//
//            while (leftIndex < leftWord.length && rightIndex < rightWord.length) {
//    const leftChar = leftWord[leftIndex];
//    const rightChar = rightWord[rightIndex];
//
//                if (leftChar === rightChar) {
//                    leftIndex++;
//                    rightIndex++;
//                } else {
//      const nextLeftChar = leftWord[leftIndex + 1];
//      const nextRightChar = rightWord[rightIndex + 1];
//
//      const leftCharEqualsNextRight = leftChar === nextRightChar;
//      const rightCharEqualsNextLeft = rightChar === nextLeftChar;
//      const nextLeftEqualsNextRight = nextLeftChar === nextRightChar;
//
//                    if (nextLeftEqualsNextRight) {
//                        leftIndex++;
//                        rightIndex++;
//                    } else if (
//                            leftCharEqualsNextRight && rightCharEqualsNextLeft ||
//                                    !leftCharEqualsNextRight && !rightCharEqualsNextLeft
//                    ) {
//                        return false;
//                    } else if (leftCharEqualsNextRight) {
//                        rightIndex++;
//                    } else if (rightCharEqualsNextLeft) {
//                        leftIndex++;
//                    } else {
//                        throw new Error('Invariant violated');
//                    }
//
//                    mismatchCount++;
//                }
//            }
//
//            return ((leftWord.length - leftIndex) + (rightWord.length - rightIndex) + mismatchCount) <= 1;
//        }
//
//    }
//}
