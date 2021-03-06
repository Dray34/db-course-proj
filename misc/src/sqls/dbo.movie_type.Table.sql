﻿USE [豆瓣数据库]
GO
/****** Object:  Table [dbo].[movie_type]    Script Date: 11/15/2019 09:50:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[movie_type](
	[type_id] [int] NOT NULL,
	[movie_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[type_id] ASC,
	[movie_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[movie_type]  WITH CHECK ADD FOREIGN KEY([movie_id])
REFERENCES [dbo].[movie] ([movie_id])
GO
ALTER TABLE [dbo].[movie_type]  WITH CHECK ADD FOREIGN KEY([type_id])
REFERENCES [dbo].[type] ([type_id])
GO
