# Krypton3
A walkthrough of a solution to the Krypton3 cipher game at overthewire[.]org
# DISCLAIMER
In the spirit of the game, you will find no password here. From the game's webpage:

Well done. You’ve moved past an easy substitution cipher. The main weakness of a simple substitution cipher is repeated use of a simple key. In the previous exercise you were able to introduce arbitrary plaintext to expose the key. In this example, the cipher mechanism is not available to you, the attacker. However, you have been lucky. You have intercepted more than one message. The password to the next level is found in the file ‘krypton4’. You have also found 3 other files. (found1, found2, found3) You know the following important details: • The message plaintexts are in American English (*** very important) - They were produced from the same key (*** even better!) Enjoy.!

Solving this game requires cryptanalysis of the found ciphertexts mentioned in the prompt. The java code in this repo conducts a cryptanalysis on the found files and outputs the result:

![alt text](https://github.com/Keen1/Krypton3/blob/main/freqa_out.png?raw=true)

Since the cipher is a simple monoalphabetic one, we can compare the distribution of letters to a frequency distribution for the entire english language(mentioned in the prompt) and determine a possible key.
