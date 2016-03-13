package com.csy.util;

import java.io.File;

public abstract class FolderUtils
{

	public FolderUtils()
	{
	}

	public static String formatPath(Object objects[])
	{
		String path = "";
		if (objects != null)
		{
			Object aobj[];
			int j = (aobj = objects).length;
			for (int i = 0; i < j; i++)
			{
				Object obj = aobj[i];
				if ("".equals(path))
					path = (new StringBuilder(String.valueOf(path))).append(obj).toString();
				else
					path = (new StringBuilder(String.valueOf(path))).append(SYS_FILE_SEPARATOR).append(obj).toString();
			}

		}
		return path;
	}

	public static boolean exists(String folder)
	{
		File file = new File(folder);
		return file.isDirectory() && file.exists();
	}

	public static boolean mkdir(String folder)
	{
		File file = new File(folder);
		if (file.exists())
		{
			if (!file.isDirectory())
				return file.mkdir();
			else
				return true;
		} else
		{
			return file.mkdir();
		}
	}

	public static boolean mkdirs(String folder)
	{
		File file = new File(folder);
		if (file.exists())
		{
			if (!file.isDirectory())
				return file.mkdirs();
			else
				return true;
		} else
		{
			return file.mkdirs();
		}
	}

	public static boolean rename(String fromFolder, String toFolder)
	{
		File fromPath = new File(fromFolder);
		File toPath = new File(toFolder);
		if (exists(fromFolder) && !exists(toFolder))
			return fromPath.renameTo(toPath);
		else
			return false;
	}

	public static boolean delete(File folder)
	{
		if (folder == null || !folder.exists() || !folder.isDirectory())
			return false;
		File files[] = folder.listFiles();
		File afile[];
		int j = (afile = files).length;
		for (int i = 0; i < j; i++)
		{
			File file = afile[i];
			if (file.isDirectory())
			{
				if (!delete(file))
					return delete(file);
			} else if (!file.delete())
				return file.delete();
		}

		return folder.delete();
	}

	public static final String SYS_FILE_SEPARATOR;

	static
	{
		SYS_FILE_SEPARATOR = File.separator;
	}
}
