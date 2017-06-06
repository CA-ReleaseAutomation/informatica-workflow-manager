/*******************************************************************************************************
*	Copyright (c) 2014 CA. All rights reserved.
*
*	This software and all information contained therein is confidential and proprietary and shall
*	not be duplicated, used, disclosed or disseminated in any way except as authorized by the
*	applicable license agreement, without the express written permission of CA. All authorized
*	reproductions must be marked with this language.
*
*	EXCEPT AS SET FORTH IN THE APPLICABLE LICENSE AGREEMENT, TO THE EXTENT PERMITTED BY APPLICABLE
*	LAW, CA PROVIDES THIS SOFTWARE WITHOUT WARRANTY OF ANY KIND, INCLUDING WITHOUT LIMITATION, ANY
*	IMPLIED WARRANTIES OF MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. IN NO EVENT WILL CA
*	BE LIABLE TO THE END USER OR ANY THIRD PARTY FOR ANY LOSS OR DAMAGE, DIRECT OR INDIRECT, FROM
*	THE USE OF THIS SOFTWARE, INCLUDING WITHOUT LIMITATION, LOST PROFITS, BUSINESS INTERRUPTION,
*	GOODWILL, OR LOST DATA, EVEN IF CA IS EXPRESSLY ADVISED OF SUCH LOSS OR DAMAGE.
********************************************************************************************************/

package com.ca.informaticaworkflowmanager;

import com.ca.nolio.rdk.dto.*;
import com.ca.nolio.rdk.dto.OS;
import com.ca.nolio.rdk.dto.exception.*;
import com.ca.nolio.rdk.template.helper.*;
import com.nolio.platform.shared.api.ActionDescriptor;
import com.nolio.platform.shared.api.ActionResult;
import com.nolio.platform.shared.api.Password;
import com.nolio.platform.shared.api.ParameterDescriptor;
import com.nolio.platform.shared.datamodel.Action;
import org.apache.commons.exec.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.log4j.Logger;
import com.jayway.jsonpath.JsonPath;
import java.io.StringReader;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import javax.xml.xpath.XPathConstants;

/**
 *
 * @author Joe Offenberg
 */
@ActionDescriptor(
        name = "IPC - Workflow Manager - Get Workflow Details",
		description = "Start an Informatica workflow",
        category="PowerCenter.Workflow Manager" )
    public class IPCWorkflowManagerGetWorkflowDetails extends Action {
    private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(IPCWorkflowManagerGetWorkflowDetails.class);
	private static final String SCAPE_CHAR = "\\";
	private List<InputParam> inputParameters = null;	
	private List<OutputParam> outputParameters = null;
    




	@ParameterDescriptor(
		name = "pmcmd path",
		description = "location of pmcmd command",
		out = false,
		in = true,
		nullable = true, // parameter not required or default value set
		order = 10,
	defaultValueAsString = "C:\\\\Informatica\\\\9.5.1\\\\clients\\\\PowerCenterClient\\\\CommandLineUtilities\\\\PC\\\\server\\\\bin"
	)

    


            private String pmcmdpath1 = "C:\\\\Informatica\\\\9.5.1\\\\clients\\\\PowerCenterClient\\\\CommandLineUtilities\\\\PC\\\\server\\\\bin";
    

	@ParameterDescriptor(
		name = "Service",
		description = "Service Description",
		out = false,
		in = true,
		nullable = false, // parameter is required and no default value set
		order = 20,
        defaultValueAsString = ""
    	)

    


            private String service2 = "C:\\\\Informatica\\\\9.5.1\\\\clients\\\\PowerCenterClient\\\\CommandLineUtilities\\\\PC\\\\server\\\\bin";
    

	@ParameterDescriptor(
		name = "Domain",
		description = "Domain Description",
		out = false,
		in = true,
		nullable = false, // parameter is required and no default value set
		order = 30,
        defaultValueAsString = ""
    	)

    




            private String domain3;
            

	@ParameterDescriptor(
		name = "User",
		description = "User Description",
		out = false,
		in = true,
		nullable = false, // parameter is required and no default value set
		order = 40,
        defaultValueAsString = ""
    	)

    




            private String user4;
            

	@ParameterDescriptor(
		name = "Password",
		description = "Password Description",
		out = false,
		in = true,
		nullable = false, // parameter is required and no default value set
		order = 50,
        defaultValueAsString = ""
    	)

    




            private Password password5;
            

	@ParameterDescriptor(
		name = "Folder",
		description = "Folder Description",
		out = false,
		in = true,
		nullable = false, // parameter is required and no default value set
		order = 60,
        defaultValueAsString = ""
    	)

    




            private String folder6;
            

	@ParameterDescriptor(
		name = "Workflow",
		description = "Workflow Description",
		out = false,
		in = true,
		nullable = false, // parameter is required and no default value set
		order = 70,
        defaultValueAsString = ""
    	)

    


            private String workflow7 = "C:\\\\Informatica\\\\9.5.1\\\\clients\\\\PowerCenterClient\\\\CommandLineUtilities\\\\PC\\\\server\\\\bin";
    

	@ParameterDescriptor(
		name = "Run ID",
		description = "Parameter File Description",
		out = false,
		in = true,
		nullable = true, // parameter not required or default value set
		order = 80,
        defaultValueAsString = ""
    	)

    




            private String runid8;
            




	@ParameterDescriptor(
		name = "Execution Output",
		description = "This output parameter holds the standard output of the command execution.",
		out = true,
		in = false
	)
	
	
	private String executionoutput1;

	@ParameterDescriptor(
		name = "Error Output",
		description = "This output parameter holds the standard error output of the command execution.",
		out = true,
		in = false
	)
	
	
	private String erroroutput2;

	@ParameterDescriptor(
		name = "Exit Code",
		description = "This output parameter holds the returned exit code of the command execution.",
		out = true,
		in = false
	)
	
	
	private Integer exitcode3;




    // Getters and Setters
        public String getpmcmdpath1() {
        return pmcmdpath1;
    }
    
    public void setpmcmdpath1(String pmcmdpath1) {
    	this.pmcmdpath1 = pmcmdpath1;
    }
	        public String getservice2() {
        return service2;
    }
    
    public void setservice2(String service2) {
    	this.service2 = service2;
    }
	        public String getdomain3() {
        return domain3;
    }
    
    public void setdomain3(String domain3) {
    	this.domain3 = domain3;
    }
	        public String getuser4() {
        return user4;
    }
    
    public void setuser4(String user4) {
    	this.user4 = user4;
    }
	        public Password getpassword5() {
        return password5;
    }
    
    public void setpassword5(Password password5) {
    	this.password5 = password5;
    }
	        public String getfolder6() {
        return folder6;
    }
    
    public void setfolder6(String folder6) {
    	this.folder6 = folder6;
    }
	        public String getworkflow7() {
        return workflow7;
    }
    
    public void setworkflow7(String workflow7) {
    	this.workflow7 = workflow7;
    }
	        public String getrunid8() {
        return runid8;
    }
    
    public void setrunid8(String runid8) {
    	this.runid8 = runid8;
    }
	    // Getters and Setters
        public String getexecutionoutput1() {
        return executionoutput1;
    }
    
    public void setexecutionoutput1(String executionoutput1) {
    	this.executionoutput1 = executionoutput1;
    }
	        public String geterroroutput2() {
        return erroroutput2;
    }
    
    public void seterroroutput2(String erroroutput2) {
    	this.erroroutput2 = erroroutput2;
    }
	        public Integer getexitcode3() {
        return exitcode3;
    }
    
    public void setexitcode3(Integer exitcode3) {
    	this.exitcode3 = exitcode3;
    }
	
    
	@Override
	public ActionResult execute() {
		ExecutionResult execResult = null;
		com.ca.nolio.rdk.dto.CLIAction action;
		try {
		    action = getCLIAction();
			final CliCommand cliCommand = CommandLineExecutorHelper.getExecutionCommand(action);
			log.debug("Command to execute  : " + cliCommand.getCommand());
			log.debug("Execution directory : " + cliCommand.getExecDir());

            execResult = CommandLineExecutorHelper.executeCommand(cliCommand);
			
			log.debug("Execution result: " + execResult.getStandardOutput());
		} catch (Exception e) {
            log.error("Action execution failed.", e);
			return new ActionResult(false, e.toString());
		}

        log.info("Populating Output Params");
		populateOutputParameters(execResult);

		return getActionResult(action);
	}	


    private void populateOutputParameters(ExecutionResult execResult) {
        if (execResult == null) {
            return;
        }
        if (execResult.isEmpty()) {
            log.debug("Execution result is empty: skip populate parameters phasis!");
            return;
        }

        String output = null;
                        log.info("Standard Input " + execResult.getStandardOutput());
        log.info("Standard Error " + execResult.getStandardError());
        if (StringUtils.isNotEmpty(execResult.getStandardOutput())) {
            output = execResult.getStandardOutput();
                            try {
                Pattern pattern = Pattern.compile("[\\s\\S]*");
                Matcher matcher = pattern.matcher(output);
                String stringMatch = null;
                if (matcher.find()) {
                    stringMatch = matcher.group();
                } else{
                    log.info("Cound not find a match for " + output + " with [\\s\\S]*");
                }

                executionoutput1 = String.valueOf(stringMatch);
                log.info("Got output " + executionoutput1);
            } catch (PatternSyntaxException e) {
                log.error("Caught exception during populating output parameter: " + "Execution Output" + ". Bad pattern", e);
            } catch (Exception e) {
                log.error("Caught exception during populating output parameter: " + "Execution Output", e);
            }
                }
                                    if (StringUtils.isNotEmpty(execResult.getStandardError())) {
            output = execResult.getStandardError();
                            try {
                Pattern pattern = Pattern.compile("[\\s\\S]*");
                Matcher matcher = pattern.matcher(output);
                String stringMatch = null;
                if (matcher.find()) {
                    stringMatch = matcher.group();
                } else{
                    log.info("Cound not find a match for " + output + " with [\\s\\S]*");
                }

                erroroutput2 = String.valueOf(stringMatch);
                log.info("Got output " + erroroutput2);
            } catch (PatternSyntaxException e) {
                log.error("Caught exception during populating output parameter: " + "Error Output" + ". Bad pattern", e);
            } catch (Exception e) {
                log.error("Caught exception during populating output parameter: " + "Error Output", e);
            }
                }
                        if (execResult.getExitCode() != null) {
                    exitcode3 = execResult.getExitCode();
                }
        
    }
	
	private ActionResult getActionResult(com.ca.nolio.rdk.dto.CLIAction action) {
		if(action == null){
			return new ActionResult(false, "Action is null");
		}
		ActionResult actionResult = new ActionResult(true, action.getSuccessMessage());
		
		StringBuilder errors = new StringBuilder();
			            	                	                    	if( ErrorHelper.testErrorCondition(exitcode3, Operations.valueOf("NOT_EQUALS"), "0")) {
    		                        errors.append( ReplacementsHelper.replaceOutputParameters( ReplacementsHelper.replaceInputParameters( "${Error Output}" , getInput() ), getOutput() ) ).append("<br/>");
						}
            	    			String errorString = errors.toString();
		if (StringUtils.isNotEmpty(errorString)) {
			actionResult = new ActionResult(false, errorString);
		}

		
		return actionResult;
	}
	

 	private List<InputParam> getInput() {
				inputParameters = new ArrayList<InputParam>();
			InputParam p = null;
					p = new InputParam();
			p.setName("pmcmd path");
			 p.setDescription("location of pmcmd command");
             p.setDefaultValue("C:\\Informatica\\9.5.1\\clients\\PowerCenterClient\\CommandLineUtilities\\PC\\server\\bin");
             p.setPrefix("");
			//p.setValue("");
			p.setVariableName("pmcmdpath");
			p.setType(VarType.String);

									    			 				p.setValue( pmcmdpath1 );
			 								
			inputParameters.add(p);		
					p = new InputParam();
			p.setName("Service");
			 p.setDescription("Service Description");
             p.setDefaultValue("2147483647");
             p.setPrefix("");
			//p.setValue("");
			p.setVariableName("service");
			p.setType(VarType.String);

									    			 				p.setValue( service2 );
			 								
			inputParameters.add(p);		
					p = new InputParam();
			p.setName("Domain");
			 p.setDescription("Domain Description");
             p.setDefaultValue("");
             p.setPrefix("");
			//p.setValue("");
			p.setVariableName("domain");
			p.setType(VarType.String);

									    			 				p.setValue( domain3 );
			 								
			inputParameters.add(p);		
					p = new InputParam();
			p.setName("User");
			 p.setDescription("User Description");
             p.setDefaultValue("");
             p.setPrefix("");
			//p.setValue("");
			p.setVariableName("user");
			p.setType(VarType.String);

									    			 				p.setValue( user4 );
			 								
			inputParameters.add(p);		
					p = new InputParam();
			p.setName("Password");
			 p.setDescription("Password Description");
             p.setDefaultValue("");
             p.setPrefix("");
			//p.setValue("");
			p.setVariableName("password");
			p.setType(VarType.Password);

									    			 								if(password5 != null) {
					p.setValue( password5.toString() );
				}
			 								
			inputParameters.add(p);		
					p = new InputParam();
			p.setName("Folder");
			 p.setDescription("Folder Description");
             p.setDefaultValue("");
             p.setPrefix("");
			//p.setValue("");
			p.setVariableName("folder");
			p.setType(VarType.String);

									    			 				p.setValue( folder6 );
			 								
			inputParameters.add(p);		
					p = new InputParam();
			p.setName("Workflow");
			 p.setDescription("Workflow Description");
             p.setDefaultValue("2147483647");
             p.setPrefix("");
			//p.setValue("");
			p.setVariableName("workflow");
			p.setType(VarType.String);

									    			 				p.setValue( workflow7 );
			 								
			inputParameters.add(p);		
					p = new InputParam();
			p.setName("Run ID");
			 p.setDescription("Parameter File Description");
             p.setDefaultValue("");
             p.setPrefix("-id");
			//p.setValue("");
			p.setVariableName("runid");
			p.setType(VarType.String);

									    			 				p.setValue( runid8 );
			 								
			inputParameters.add(p);		
				
	 		return inputParameters;
	}	
	
	
	private List<OutputParam> getOutput() {
			if (outputParameters == null) {
			outputParameters = new ArrayList<OutputParam>();
			OutputParam p = null;
					p = new OutputParam();
			p.setName("Execution Output");
			            			p.setVariableName("executionoutput");
			p.setType(VarType.String);
			
							p.setFilterType(FilterType.REGEX);
						
									    			 				p.setFilterValue( executionoutput1 );
			 						
			outputParameters.add(p);					
					p = new OutputParam();
			p.setName("Error Output");
			            			p.setVariableName("erroroutput");
			p.setType(VarType.String);
			
							p.setFilterType(FilterType.REGEX);
						
									    			 				p.setFilterValue( erroroutput2 );
			 						
			outputParameters.add(p);					
					p = new OutputParam();
			p.setName("Exit Code");
			            			p.setVariableName("exitcode");
			p.setType(VarType.Integer);
			
							p.setFilterType(FilterType.REGEX);
						
									    			 								if(exitcode3 != null) {
					p.setFilterValue( exitcode3.toString() );
				}
			 						
			outputParameters.add(p);					
				}
			return outputParameters;
	}
		
		


	private List<ErrorCondition> getErrorConditions(){
		List<ErrorCondition> errorCondition = null;
		
		errorCondition = new ArrayList<ErrorCondition>();
		ErrorCondition ec = null;
					ec = new ErrorCondition();
			ec.setMessage("${Error Output}");		
			ec.setParameter("Exit Code");
			ec.setValue("0");
							ec.setOperation(Operations.NOT_EQUALS);
							
		return errorCondition;
	}


	private List<CliCommand> getCliCommands(){
		List<CliCommand> cliCommands = new ArrayList<CliCommand>();
		
		CliCommand cliCmd = null;
		List<EnvVariable> envList = null;
		EnvVariable env = null;
		Script script = null;
								
					cliCmd = new CliCommand();
											cliCmd.setOsType(OS.WINDOWS);
										
					cliCmd.setCommand("pmcmd getworkflowdetails -service ${Service} -d ${Domain} -u ${User} -p ${Password} -f ${Folder} ${Run ID} ${Workflow}");											
					cliCmd.setExecDir("${pmcmd path}");									
					
										
					cliCmd.setWaitForProcessToFinish(false);
					cliCmd.setOverwriteOutput(false);
															
											cliCmd.setTimeout(30);
										
					
										
					
					cliCommands.add(cliCmd);
																				
						
					cliCmd = new CliCommand();
											cliCmd.setOsType(OS.LINUX);
										
					cliCmd.setCommand("");											
					cliCmd.setExecDir("/tmp/");									
					
										
					cliCmd.setWaitForProcessToFinish(false);
					cliCmd.setOverwriteOutput(false);
															
											cliCmd.setTimeout(30);
										
					
										
					
					cliCommands.add(cliCmd);
																				
								
		return cliCommands;
	}




	

private com.ca.nolio.rdk.dto.CLIAction getCLIAction() {
	com.ca.nolio.rdk.dto.CLIAction action = new com.ca.nolio.rdk.dto.CLIAction();

	action.setShellType(Shell.DEFAULT_OS);
					
	action.setCliCommands(getCliCommands());			
	action.setInputParamList(getInput());
	action.setName("IPC - Workflow Manager - Get Workflow Details");
	action.setDescription("Start an Informatica workflow");
	action.setCategory("Workflow Manager");				
	action.setSuccessMessage("Execution succeeded");	
	return action;
}
}
