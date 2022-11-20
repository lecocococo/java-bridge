package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> answerBridge, List<String> playerBridge) {
        StringBuilder upBridge = new StringBuilder();
        StringBuilder downBridge = new StringBuilder();

        addBridgeStart(upBridge, downBridge);
        for (int i = 0; i < playerBridge.size(); i++) {
            String playerBridgePart = playerBridge.get(i);
            if (playerBridgePart.equals(answerBridge.get(i))) {
                addBridgePartSuccess(playerBridgePart, upBridge, downBridge);
            }
            if (!playerBridgePart.equals(answerBridge.get(i))) {
                addBridgePartFail(playerBridgePart, upBridge, downBridge);
            }
            if ( i != playerBridge.size() - 1){
                upBridge.append("| ");
                downBridge.append("| ");
            }
        }

        addBridgeEnd(upBridge, downBridge);

        System.out.println(upBridge);
        System.out.println(downBridge);
    }

    private void addBridgeStart(StringBuilder upBridge, StringBuilder downBridge) {
        upBridge.append("[ ");
        downBridge.append("[ ");
    }

    private void addBridgeEnd(StringBuilder upBridge, StringBuilder downBridge) {
        upBridge.append("]");
        downBridge.append("]");
    }

    private void addBridgePartSuccess(String playerBridgePart, StringBuilder upBridge, StringBuilder downBridge) {
        if (playerBridgePart.equals("U")){
            upBridge.append("O ");
            downBridge.append("  ");
        }
        if (playerBridgePart.equals("D")){
            upBridge.append("  ");
            downBridge.append("O ");
        }
    }

    private void addBridgePartFail(String playerBridgePart, StringBuilder upBridge, StringBuilder downBridge) {
        if (playerBridgePart.equals("U")){
            upBridge.append("X ");
            downBridge.append("  ");
        }
        if (playerBridgePart.equals("D")){
            upBridge.append("  ");
            downBridge.append("X ");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}