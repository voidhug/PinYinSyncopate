import TrieCo.TrieTree;
import tool.FileTools;

import java.util.ArrayList;
import java.util.List;

public class TireTest {

    static TrieTree tree = new TrieTree("root");
    
    public static void main(String[] args) {
        String spell = "qinshimingyuezhijunlintianxia";
        initSpells();
        System.out.println(tree.splitSpell(spell));
    }
    
    private static void initSpells() {
        List<String> spells = new ArrayList<String>();
        FileTools.readFile(spells, "./files/spell.txt");
        for (int i = 0; i < spells.size(); i++) {
            tree.insert(spells.get(i));
        }
    }
}
