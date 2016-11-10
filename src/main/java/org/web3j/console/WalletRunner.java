package org.web3j.console;

import org.web3j.utils.Console;

import static org.web3j.utils.Collection.tail;

/**
 * Class for managing our wallet command line utilities.
 */
public class WalletRunner {
    private static final String USAGE = "wallet create|update|send";

    public static void main(String[] args) {
        if (args.length < 1) {
            Console.exitError(USAGE);
        } else {
            switch (args[0]) {
                case "create":
                    WalletCreator.main(new String[] {});
                    break;
                case "update":
                    WalletUpdater.main(tail(args));
                    break;
                case "send":
                    WalletSendFunds.main(tail(args));
                    break;
                default:
                    Console.exitError(USAGE);
            }
        }
    }
}