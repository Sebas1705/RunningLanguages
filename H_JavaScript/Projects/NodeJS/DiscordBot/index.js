const {Client, EmbedBuilder} = require("discord.js")
const {Configuration, OpenAIApi} = require("openai")

const client = new Client({intents:[3276799]})

const config = require("./config.json")

client.on("ready", () => {
    console.log("Bot iniciado correctamente...")
})
  
const configuration = new Configuration({
    organization: config.organization_id,
    apiKey: config.openai_key,
});
  
const openai = new OpenAIApi(configuration);
  
client.on('messageCreate', async (message) => {
    if (message.author.bot) return;
    if (message.channel.id !== config.channel_id) return;
    if (message.content.startsWith('/')) return;

    try {
        if(message.content.startsWith("!gpt ")){
            const  gptResponse=await openai.createCompletion({
                model: "gpt-3.5-turbo",
                prompt: `ChatGPT es un chatbot sarcastico y gracioso en español.\n
                ${message.author.username}: ${message.content.split("!gpt ")[0]}\nChatGPT:`,
                temperature: 0.9,
                max_tokens: 100,
                stop: ["ChatGPT:"]
            })

            message.reply(gptResponse.data.choices[0].text)
            return
        }else if(!message.content.startsWith('!')){
            message.reply("Comando no identificado prueba con /help")
            return
        }
    } catch (error) {
        message.reply(`${error}`);
    }
});

client.login(config.token)