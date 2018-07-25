#！/bin/bash

java -jar console/build/libs/console-3.2.0-all.jar solidity generate benchmark/src/main/resources/bin/register.bin benchmark/src/main/resources/abi/register.abi -o benchmark/src/main/java/ -p org.web3j.dj

java -jar console/build/libs/console-3.2.0-all.jar solidity generate benchmark/src/main/resources/bin/basic_info_op.bin benchmark/src/main/resources/abi/basic_info_op.abi -o benchmark/src/main/java/ -p org.web3j.dj

java -jar console/build/libs/console-3.2.0-all.jar solidity generate benchmark/src/main/resources/bin/dev_process_op.bin benchmark/src/main/resources/abi/dev_process_op.abi -o benchmark/src/main/java/ -p org.web3j.dj

java -jar console/build/libs/console-3.2.0-all.jar solidity generate benchmark/src/main/resources/bin/meeting_op.bin benchmark/src/main/resources/abi/meeting_op.abi -o benchmark/src/main/java/ -p org.web3j.dj

java -jar console/build/libs/console-3.2.0-all.jar solidity generate benchmark/src/main/resources/bin/mem_id_op.bin benchmark/src/main/resources/abi/mem_id_op.abi -o benchmark/src/main/java/ -p org.web3j.dj

java -jar console/build/libs/console-3.2.0-all.jar solidity generate benchmark/src/main/resources/bin/org_info_op.bin benchmark/src/main/resources/abi/org_info_op.abi -o benchmark/src/main/java/ -p org.web3j.dj

java -jar console/build/libs/console-3.2.0-all.jar solidity generate benchmark/src/main/resources/bin/basic_info.bin benchmark/src/main/resources/abi/basic_info.abi -o benchmark/src/main/java/ -p org.web3j.dj

java -jar console/build/libs/console-3.2.0-all.jar solidity generate benchmark/src/main/resources/bin/party_mem_id.bin benchmark/src/main/resources/abi/party_mem_id.abi -o benchmark/src/main/java/ -p org.web3j.dj

java -jar console/build/libs/console-3.2.0-all.jar solidity generate benchmark/src/main/resources/bin/party_mem_info.bin benchmark/src/main/resources/abi/party_mem_info.abi -o benchmark/src/main/java/ -p org.web3j.dj

