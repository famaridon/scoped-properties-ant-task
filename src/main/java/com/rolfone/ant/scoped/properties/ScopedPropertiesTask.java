package com.rolfone.ant.scoped.properties;

import com.rolfone.maven.scoped.properties.exceptions.BuildPropertiesFilesException;
import com.rolfone.maven.scoped.properties.utils.ScopedPropertiesUtils;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

import java.io.File;

/**
 * Created by famaridon on 10/07/2014.
 */
public class ScopedPropertiesTask extends Task
{

	/**
	 * specify the input XML descriptor folder
	 */
	protected String propertiesXmlFolder;

	/**
	 * specify the .properties file output folder
	 */
	protected String outputFolder;

	/**
	 * the XML descriptor's scope used to build .properties files
	 */
	protected String targetScope;

	@Override
	public void execute() throws BuildException
	{

		super.execute();
		try
		{
			ScopedPropertiesUtils.buildPropertiesFiles(new File(this.propertiesXmlFolder), new File(this.getOutputFolder()), this.targetScope);
		} catch (BuildPropertiesFilesException e)
		{
			throw new BuildException(e);
		}
	}

	public String getPropertiesXmlFolder()
	{
		return propertiesXmlFolder;
	}

	public void setPropertiesXmlFolder(String propertiesXmlFolder)
	{
		this.propertiesXmlFolder = propertiesXmlFolder;
	}

	public String getOutputFolder()
	{
		return outputFolder;
	}

	public void setOutputFolder(String outputFolder)
	{
		this.outputFolder = outputFolder;
	}

	public String getTargetScope()
	{
		return targetScope;
	}

	public void setTargetScope(String targetScope)
	{
		this.targetScope = targetScope;
	}
}
