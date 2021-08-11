package com.example.gamix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameDetails extends AppCompatActivity{
TextView logOut,gameText,resText,genTest,webText,textButton;
Button goBackButton;
Bundle b;
private GameDatabase myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_details);
        logOut =findViewById(R.id.logOut);
        gameText = findViewById(R.id.gameText);
        resText = findViewById(R.id.reqText);
        genTest = findViewById(R.id.genreText);
        webText = findViewById(R.id.webText);
        goBackButton = findViewById(R.id.goBackBtn);

        String gameName,requirements,genre,website;

        b = this.getIntent().getExtras();
//        textButton.setText(b.getString("userNames"));
        myDb = new GameDatabase(GameDetails.this);   //Initialise database

        myDb.addSetting("cod","Call Of Duty Black Ops Cold War",
                "CPU:\tIntel Core i3-4340 or AMD FX-6300\n" +
                        "\nRAM:\t8GB\n" +
                        "\nGPU:\tNVIDIA GeForce GTX 670 / GeForce GTX 1650 or Radeon HD 7950\n" +
                        "\nDX:\tDirectX 12.0 compatible system\n" +
                        "\nOS:\tWindows 7 64-Bit (SP1) or Windows 10 64-Bit (v.1803 or higher",
                "Action, FPS","https://www.callofduty.com/blackopscoldwar");

        myDb.addSetting("gta5","Grand Theft Auto V",
                "CPU:\tIntel Core 2 Quad CPU Q6600 @ 2.40GHz (4 CPUs) / AMD Phenom 9850 Quad-Core Processor (4 CPUs) @ 2.5GHz\n" +
                "\nRAM:\t4 GB\n" +
                "\nGPU:\tNVIDIA 9800 GT 1GB / AMD HD 4870 1GB (DX 10, 10.1, 11)\n" +
                "\nDX:\t10\n" +
                "\nOS:\tWindows 10 64 Bit, Windows 8.1 64 Bit, Windows 8 64 Bit, Windows 7 64 Bit Service Pack 1\n" +
                "\nStorage:\t72 GB available space",
                "Action, Adventure","https://www.rockstargames.com/V/");

        myDb.addSetting("nfs","Need For Speed Heat",
                "CPU:\tFX-6350 or Equivalent / Core i5-3570 or Equivalent\n" +
                        "\nRAM:\t8 GB\n" +
                        "\nGPU:\tRadeon 7970/Radeon R9 280x or Equivalent / GeForce GTX 760 or Equivalent\n" +
                        "\nDX:\t11\n" +
                        "\nOS:\tWindows 10, 64-bit\n" +
                        "\nStore:\t50 GB",
                "Racing","https://www.ea.com/en-gb/games/need-for-speed/need-for-speed-heat");

        myDb.addSetting("csgo","Counter-Strike: Global Offensive",
                "CPU:\tIntel® Core™ 2 Duo E6600 or AMD Phenom™ X3 8750 processor or better\n" +
                        "\nRAM:\t2 GB\n" +
                        "\nGPU:\tVideo card must be 256 MB or more and should be a DirectX 9-compatible with support for Pixel Shader 3.0\n" +
                        "\nDX:\tVersion 9.0c\n" +
                        "\nOS:\tWindows® 7/Vista/XP\n" +
                        "\nStorage:\t15 GB",
                "Action, FPS","https://store.steampowered.com/app/730/CounterStrike_Global_Offensive/");

        myDb.addSetting("re","Resident Evil Village",
                "CPU:\tIntel Core i5-7500 ／ AMD Ryzen 3 1200\n" +
                        "\nRAM:\t8 GB\n" +
                        "\nGPU:\tNVIDIA GeForce GTX 1050 Ti with 4GB VRAM ／ AMD Radeon RX 560 with 4GB VRAM\n" +
                        "\nDX:\tVersion 12\n" +
                        "\nOS:\tWindows 10 (64 bit)",
                "Action, Survival horror, First person","https://www.residentevil.com/village/uk/");

        myDb.addSetting("val","VALORANT",
                "CPU:\tIntel Core 2 Duo E8400\n" +
                        "\nRAM:\t4 GB\n" +
                        "\nGPU:\tIntel HD 4000 (1GB VRAM)\n" +
                        "\nOS:\tWindows 7/8/10 (64-bit)\n" +
                        "\nResolution:\t30 fps",
                "Action, FPS\n","https://playvalorant.com/en-us/");

        myDb.addSetting("amngus","AMONG US","CPU:\tSSE2 instruction set support\n" +
                "\nRAM:\t1 GB\n" +
                "\nGPU:\t(Any)\n" +
                "\nDX:\tVersion 10\n" +
                "\nOS:\tWindows 7 SP1+","Casual, Party","https://innersloth.com/gameAmongUs.php");

        myDb.addSetting("pes","PES 2020",
                "CPU:\tIntel Core i5-3470 / AMD FX 4350\n" +
                        "\nRAM:\t4 GB\n" +
                        "\nGPU:\tNVIDIA GTX 670 / AMD Radeon HD 7870\n" +
                        "\nDX:\tVersion 11\n" +
                        "\nOS:\tWindows 7 SP1/8.1/10 - 64bit\n" +
                        "\nStore:\t40 GB available space",
                "Sports","https://www.konami.com/wepes/2020/eu/en/ps4/");

        myDb.addSetting("fifa","FIFA 20",
                "CPU:\tAMD Phenom II X4 965 or Equivalent / Intel i3-2100 or Equivalent\n" +
                        "\nRAM:\t8 GB\n" +
                        "\nGPU:\tAMD Radeon HD 7850 or Equivalent / Nvidia GeForce GTX 660 or Equivalent\n" +
                        "\nOS:\t64-bit Windows 7/8.1/10\n" +
                        "\nStorage:\t50 GB",
                "Sports","https://www.ea.com/en-gb/games/fifa/fifa-20");

        myDb.addSetting("mine","MINECRAFT",
                "CPU:\tIntel Core i3-3210 / AMD A8-7600 APU or equivalent\n" +
                        "\nRAM:\t4 GB (2GB free)\n" +
                        "\nGPU:\tIntegrated: Intel HD Graphics 4000 (Ivy Bridge) or AMD Radeon R5 series (Kaveri line) with OpenGL 4.41\n" +
                        "\nDiscrete: Nvidia GeForce 400 Series or AMD Radeon HD 7000 series with OpenGL 4.4\n" +
                        "\nOS:\tWindows 7 or later, OS X 10.9 Maverick, Linux: Any distribution from 2014 or later",
                "Action, Survival","https://www.minecraft.net/");

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameDetails.this,MainActivity.class);
                startActivity(i);
            }
        });

        gameName = myDb.getGameName(b.getString("gameNames"));
        requirements = myDb.getRequirement(b.getString("gameNames"));
        genre = myDb.getGenre(b.getString("gameNames"));
        website = myDb.getWebsite(b.getString("gameNames"));

        gameText.setText(gameName);
        resText.setText(requirements);
        genTest.setText(genre);
        webText.setText(website);

        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(GameDetails.this,GameList.class);
//                startActivity(i);
                onBackPressed();
            }
        });
    }
}
