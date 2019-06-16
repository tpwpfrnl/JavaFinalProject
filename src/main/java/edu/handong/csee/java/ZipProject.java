package edu.handong.csee.java;

import java.util.ArrayList;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import edu.handong.csee.java.utils.SeveralExceptions;
import edu.handong.csee.java.utils.ZipReader;

public class ZipProject {
	
	String input;
	String output;
	boolean help;
	
	public void run(String args[]) {
		Options options = createOptions();
		if(parseOptions(options, args)) {
			if(help) {
				printHelp(options);
				return;
			}
			try {
				if(args.length<2) {
					throw new SeveralExceptions();					
				}
			} catch (SeveralExceptions e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
			String dataPath = input;
			String resultPath = output;
			
			ArrayList<String> lines = ZipReader.readFileInZip(dataPath);
//			ArrayList<String> linesToBeSaved2 = courseInformation(lines);
//			Utils.writeAFile(linesToBeSaved2, resultPath, 2);
		}
	}
	
	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine cmd = parser.parse(options, args);

			input = cmd.getOptionValue("i");
			output = cmd.getOptionValue("o");
			help = cmd.hasOption("h");
		} catch (Exception e) {
			printHelp(options);
			return false;
		}
		return true;
	}
	
	private Options createOptions() {
		Options options = new Options();
		
		// add options by using OptionBuilder
		options.addOption(Option.builder("i").longOpt("input")
				.desc("Set an input file path")
				.hasArg()
				.argName("Input path")
				.required()
				.build());
		
		// add options by using OptionBuilder
		options.addOption(Option.builder("o").longOpt("output")
				.desc("Set an output file path")
				.hasArg()
				.argName("Output path")
				.required()
				.build());
		
		// add options by using OptionBuilder
		options.addOption(Option.builder("h").longOpt("help")
				.desc("Show a Help page")
				.argName("Help")
				.build());
		
		return options;
	}
	
	private void printHelp(Options options) {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		String header = "~~~JavaFinalProject~~~";
		String footer ="~~~This program made in 2019~~~";
		formatter.printHelp("JavaFinalProject", header, options, footer, true);
	}
}
