package anh.ngo;

import org.bitcoinj.core.Base58;
import org.p2p.solanaj.core.Account;
import org.p2p.solanaj.core.PublicKey;
import org.p2p.solanaj.core.Transaction;
import org.p2p.solanaj.programs.SystemProgram;
import org.p2p.solanaj.rpc.Cluster;
import org.p2p.solanaj.rpc.RpcClient;
import org.p2p.solanaj.rpc.RpcException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void threadSleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws RpcException {
        RpcClient client = new RpcClient(Cluster.DEVNET);

        // Sử dụng một chuỗi Base58 hợp lệ thay vì hex.
        PublicKey mainPublicKey = new PublicKey("NbMPFownKdqHcLTNnbr1rM7JYTKZifTrUoQLfBTMsTc");
        PublicKey toPublicKey = new PublicKey("9U1kCydf5PCspt7D1mJwtYvTiPBtvKeuJRJqw3YQ62yx"); //NGTRPHUC
        long balance = client.getApi().getBalance(mainPublicKey);
        float balanceConvert = balance / 1000000000f;
        System.out.println("Tổng Sol : " + balanceConvert);

        int lamports = 1110000000; // 1 SOL

        String secret_key = "5w8FZKtujkndedrc7xLwerMKA3hH2tRCZaTvrD5MG73G6486STo3JMqXLbdPBrGonbYEB7obU3KJx8Fh3xjQ1LE2";
        byte[] secretKeyBytes = Base58.decode(secret_key);
        Account signer = new Account(secretKeyBytes);
        if (balance < lamports) {
            System.out.println("Không đủ Sol đòi chuyển ??");
        } else {
            Transaction transaction = new Transaction();
            try {
                transaction.addInstruction(SystemProgram.transfer(mainPublicKey, toPublicKey, lamports));
                String signature = client.getApi().sendTransaction(transaction, signer);
                System.out.println("Signature: " + signature);
//            ConfirmedTransaction confirmedTransaction = client.getApi().getTransaction(signature);
//            System.out.println("Confirmed transaction: " + confirmedTransaction);
            } catch (RpcException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
