package com.iphone567.uplaod;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 * 实现上传功能
 * 
 * @author Nihility-Ming
 *
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain; charset=utf-8");
		try {
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);

			if (!isMultipart) {
				throw new RuntimeException("is not multipart/form-data!");
			}

			// Create a factory for disk-based file items
			FileItemFactory factory = new DiskFileItemFactory();

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			// 限制总文件大小5MB
			upload.setSizeMax(1024 * 1024 * 5);
			// 限制单个文件上传 5MB
			upload.setFileSizeMax(1024 * 1024 * 3);

			// Parse the request

			@SuppressWarnings("unchecked")
			List<FileItem> items = upload.parseRequest(request);
			// Process the uploaded items
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();

				// 是否表单字段
				if (item.isFormField()) {
					processFormField(item);
				} else {
					processUploadedFile(item);
				}
			}

		} catch (Exception e) {
			response.getWriter().println("上存文件失败了！");
		}
	}

	private void processUploadedFile(FileItem item) {
		String fieldName = item.getFieldName();
		// 1. 解决低版本浏览器文件名问题
		String fileName = FilenameUtils.getName(item.getName());
		String contentType = item.getContentType();
		boolean isInMemory = item.isInMemory();
		long sizeInBytes = item.getSize();

		System.out.println("fieldName: " + fieldName);
		System.out.println("fileName: " + fileName);
		System.out.println("contentType: " + contentType);
		System.out.println("isInMemory: " + isInMemory);
		System.out.println("sizeInBytes: " + sizeInBytes);

		// 2. 按照日期存，避免文件过多
		// String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(new
		// Date());
		// String path = this.getServletContext().getRealPath("upload" +
		// File.separator + dateStr);

		// 2.1 按照hash值前两个字符建立二级目录，避免文件过多
		String haxStr = Integer.toHexString(fileName.hashCode());
		String path = this.getServletContext()
				.getRealPath("upload" + File.separator + haxStr.charAt(0) + File.separator + haxStr.charAt(1));

		File uploadDir = new File(path);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}

		// 3. 解决文件重名覆盖问题
		String uploadFileName = UUID.randomUUID().toString() + "_" + FilenameUtils.getName(item.getName());
		File uploadFile = new File(uploadDir, uploadFileName);
		try {
			item.write(uploadFile);
			System.out.println("已经上存到文件路径:" + uploadFile);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void processFormField(FileItem item) {
		String name = item.getFieldName();
		String value = null;
		try {
			value = new String(item.getString().getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("name: " + name + " value: " + value);
	}

}
