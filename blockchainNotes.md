# Block-chains
Block chain has  3 main components, blocks, hashes and nodes.
In simplest representation block chains are like linked list that span multiple locations at once and are a very  secured means of holding on to data.
Each block consists of 3 components:
- Data: The actual chunk of data native to that block
- Previous hash: The hash of the node preceding it
- Hash: It's own hash

Blockchain hashes should meet the following 5 requirements:
- One-way: A file cannot be reconstructed based on the hash, this is not compression it is crypto representation. File cannot be reconstructed
- Deterministic: Same file can have the same hashing algorithm applied to it multiple times the same result will be generated
- Fast computation: Aiming for O(1) time, since it will be used dozens and dozens of times
- Snowballing: If the tiniest bit is changed in the file, the entire hash must change and change definitively, no pattern should repeat
- Collision durability: The pigeonhole principle, the hash is limited to 64 characters. Algorithm must account for forced collisions.

It's own hash is computed by the combination of the data and the previous hash. Any change of the data or hashes will make the node lose it's connection to other nodes and make it's own hash change, in order to affect the full chain and extract data you will have to change every node in the chain which is impossible since if a node is affected it loses it's connection to the others causing the attack to fail.

Blockchain follows 10 promises and should have the following properties:
- Security: Nobody can tamper with the data
- Access Control: Users decide who can access their data
- Transparency: Nobody can hide things
-  Traceability: Nobody can fake origins or stub routes
- Borderless: Data can be accessed anywhere from any device in any country
- No intermediaries: Nobody stands between the participants
- Reduced Costs: Cheaper transactions than the alternative
- Speed: Faster than the alternative
- Efficiency: Replaces multiple systems with one
- Data ownership: Nobody owns or centrally stores a user's data
